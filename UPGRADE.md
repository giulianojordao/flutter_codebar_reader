# Upgrade from 2.x to 3.0.0

- The `CodebarScan.scan()` method returns a [`ScanResult`](./lib/model/scan_result.dart).
  The barcode is stored in `ScanResult.rawContent`
  Check your calls to this method and read the barcode from the `rawContent` property.
- The following static strings of class `CodebarScanner` are now written in camelCase (as opposed to PascalCase like before):
  - `cameraAccessGranted`
  - `cameraAccessDenied`

If your project uses pre Flutter 1.12 you need to update Flutter in your App: https://github.com/flutter/flutter/wiki/Upgrading-pre-1.12-Android-projects


# Upgrade from 1.0.0 to 2.0.0

The simples way for upgrading is by replacing:
- `br.com.scrumlab.barcodescan`
- `com.yourcompany.barcodescan`
- `br.com.scrumlab.barcode_scan`

With: `br.com.scrumlab.codebarscan`

Detailed changes:
Android:
Kotlin Package: `br.com.scrumlab.barcodescan` -> `br.com.scrumlab.codebarscan`
Manifest-Package: `com.yourcompany.barcodescan` -> `de.mintware.barcodescan`
Activity: `br.com.scrumlab.barcodescan.CodebarScannerActivity` -> `br.com.scrumlab.codebarscan.CodebarScannerActivity`

iOS:
Bundle ID: `br.com.scrumlab.barcode.plugin.example` -> `br.com.scrumlab.codebarscan.plugin.example`

Flutter:
Method channel: `br.com.scrumlab.barcode_scan` -> `br.com.scrumlab.codebarscan`
pubspec.yaml:
 - homepage updated
 - deprecated author entry removed
 - comments removed
 - flutter.plugin.androidPackage: `br.com.scrumlab.barcode_scan` -> `br.com.scrumlab.codebarscan`
