//
//  CodebarScannerViewControllerDelegate.swift
//  barcode_scan
//
//  Created by Giuliano Jordao on 20.02.20.
//
import Foundation

protocol CodebarScannerViewControllerDelegate {
    func didScanBarcodeWithResult(_ controller: CodebarScannerViewController?,
                                  scanResult: ScanResult
    )
    
    func didFailWithErrorCode(_ controller: CodebarScannerViewController?,
                              errorCode: String
    )
}
