package br.com.scrumlab.codebarscan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.zxing.BarcodeFormat
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class CodebarScannerActivity : Activity(), ZXingScannerView.ResultHandler {

    init {
        title = ""
    }

    private lateinit var config: Protos.Configuration
    private var scannerView: ZXingScannerView? = null

    companion object {
        const val TOGGLE_FLASH = 200
        const val CANCEL = 300
        const val EXTRA_CONFIG = "config"
        const val EXTRA_RESULT = "scan_result"
        const val EXTRA_ERROR_CODE = "error_code"

        private val formatMap: Map<Protos.CodebarFormat, BarcodeFormat> = mapOf(
                Protos.CodebarFormat.aztec to BarcodeFormat.AZTEC,
                Protos.CodebarFormat.code39 to BarcodeFormat.CODE_39,
                Protos.CodebarFormat.code93 to BarcodeFormat.CODE_93,
                Protos.CodebarFormat.code128 to BarcodeFormat.CODE_128,
                Protos.CodebarFormat.dataMatrix to BarcodeFormat.DATA_MATRIX,
                Protos.CodebarFormat.ean8 to BarcodeFormat.EAN_8,
                Protos.CodebarFormat.ean13 to BarcodeFormat.EAN_13,
                Protos.CodebarFormat.interleaved2of5 to BarcodeFormat.ITF,
                Protos.CodebarFormat.pdf417 to BarcodeFormat.PDF_417,
                Protos.CodebarFormat.qr to BarcodeFormat.QR_CODE,
                Protos.CodebarFormat.upce to BarcodeFormat.UPC_E
                Protos.CodebarFormat.brazilianboleto to BarcodeFormat.ITF,
                Protos.CodebarFormat.febraban to BarcodeFormat.ITF,
                Protos.CodebarFormat.itf to BarcodeFormat.ITF,
        )

    }

    // region Activity lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        config = Protos.Configuration.parseFrom(intent.extras!!.getByteArray(EXTRA_CONFIG))
    }

    private fun setupScannerView() {
        if (scannerView != null) {
            return
        }

        scannerView = ZXingAutofocusScannerView(this).apply {
            setAutoFocus(config.android.useAutoFocus)
            val restrictedFormats = mapRestrictedBarcodeTypes()
            if (restrictedFormats.isNotEmpty()) {
                setFormats(restrictedFormats)
            }

            // this parameter will make your HUAWEI phone works great!
            setAspectTolerance(config.android.aspectTolerance.toFloat())
            if (config.autoEnableFlash) {
                flash = config.autoEnableFlash
                invalidateOptionsMenu()
            }
        }

        setContentView(scannerView)
    }

    // region AppBar menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        var buttonText = config.stringsMap["flash_on"]
        if (scannerView?.flash == true) {
            buttonText = config.stringsMap["flash_off"]
        }
        val flashButton = menu.add(0, TOGGLE_FLASH, 0, buttonText)
        flashButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        val cancelButton = menu.add(0, CANCEL, 0, config.stringsMap["cancel"])
        cancelButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == TOGGLE_FLASH) {
            scannerView?.toggleFlash()
            this.invalidateOptionsMenu()
            return true
        }
        if (item.itemId == CANCEL) {
            setResult(RESULT_CANCELED)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        scannerView?.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        setupScannerView()
        scannerView?.setResultHandler(this)
        if (config.useCamera > -1) {
            scannerView?.startCamera(config.useCamera)
        } else {
            scannerView?.startCamera()
        }
    }
    // endregion

    override fun handleResult(result: Result?) {
        val intent = Intent()

        val builder = Protos.ScanResult.newBuilder()
        if (result == null) {

            builder.let {
                it.format = Protos.CodebarFormat.unknown
                it.rawContent = "No data was scanned"
                it.type = Protos.ResultsType.Error
            }
        } else {

            val format = (formatMap.filterValues { it == result.barcodeFormat }.keys.firstOrNull()
                    ?: Protos.CodebarFormat.unknown)

            var formatNote = ""
            if (format == Protos.CodebarFormat.unknown) {
                formatNote = result.barcodeFormat.toString()
            }

            builder.let {
                it.format = format
                it.formatNote = formatNote
                it.rawContent = result.text
                it.type = Protos.ResultsType.Barcode
            }
        }
        val res = builder.build()
        intent.putExtra(EXTRA_RESULT, res.toByteArray())
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun mapRestrictedBarcodeTypes(): List<CodebarFormat> {
        val types: MutableList<CodebarFormat> = mutableListOf()

        this.config.restrictFormatList.filterNotNull().forEach {
            if (!formatMap.containsKey(it)) {
                print("Unrecognized")
                return@forEach
            }

            types.add(formatMap.getValue(it))
        }

        return types
    }
}
