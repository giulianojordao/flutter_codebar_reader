[![GitHub license](https://img.shields.io/github/license/giulianojordao/flutter_codebar_reader)](https://github.com/giulianojordao/flutter_codebar_reader/blob/master/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/giulianojordao/flutter_codebar_reader)](https://github.com/giulianojordao/flutter_codebar_reader/stargazers)
[![Pub](https://img.shields.io/endpoint?url=https%3A%2F%2Fgiulianojordao.github.io%2Fflutter_codebar_reader%2Fdata%2Fpublish.json)](https://pub.dartlang.org/packages/barcode_scan)
[![GitHub forks](https://img.shields.io/github/forks/giulianojordao/flutter_codebar_reader)](https://github.com/giulianojordao/flutter_codebar_reader/network)
[![GitHub identity](https://img.shields.io/endpoint?url=https%3A%2F%2Fgiulianojordao.github.io%2Fflutter_codebar_reader%2Fdata%2Fidentity.json)](https://github.com/giulianojordao/flutter_codebar_reader/identity)
[![GitHub followers](https://img.shields.io/github/followers/giulianojordao?label=Followed&style=social)](https://github.com/giulianojordao/followers)
[![GitHub tweet](https://img.shields.io/twitter/url?url=https%3A%2F%2Fgithub.com%2Fgiulianojordao%2Fflutter_codebar_reader
)](https://github.com/giulianojordao/flutter_codebar_reader)



# Flutter library to read brazilian boletos barcodes

This is a revision of a version previously developed for Android and IOS. Supports for new bar code standards have been added, mainly aimed at commercial and financial activities in Brazil.

For general uses that do not specifically require this type of support, I suggest and recommend the Firebase ML Vision package as an alternative: https://pub.dev/packages/firebase_ml_vision

# Codebar Scanner

A flutter plugin for scanning Brazilian Boletos, Brazilian bank checks, 2D barcodes and QR codes. 

This provides a simple wrapper for two commonly used iOS and Android libraries:

iOS: https://github.com/mikebuss/MTBCodebarScanner

Android: https://github.com/dm77/barcodescanner

### Features
- [x] Scan Brazilian boletos (bankslip payment)
- [x] Scan Brazilian bank checks 
- [x] Scan 2D barcodes
- [x] Scan 2D barcodes
- [x] Scan QR codes
- [x] Control the flash while scanning
- [x] Permission handling

## Getting Started

### Android
For Android, you must do the following before you can use the plugin:

* Add the camera permission to your AndroidManifest.xml
     
     `<uses-permission android:name="android.permission.CAMERA" />`

* This plugin is written in Kotlin. Therefore, you need to add Kotlin support to your project. See [installing the Kotlin plugin](https://kotlinlang.org/docs/tutorials/kotlin-android.html#installing-the-kotlin-plugin).

Edit your project-level build.gradle file to look like this:
```groovy
buildscript {
    ext.kotlin_version = '1.3.61'
    // ...
    dependencies {
        // ...
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}
// ...
```

Edit your app-level build.gradle file to look like this:

```groovy
apply plugin: 'kotlin-android'
// ...
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    // ...
}
```

Now you can depend on the barcode_scan plugin in your pubspec.yaml file:

```yaml
dependencies:
    # ...
    barcode_scan: any
```
Click "Packages get" in Android Studio or run `flutter packages get` in your project folder.

### iOS
To use on iOS, you must add the the camera usage description to your Info.plist

```xml
<dict>
    <!-- ... -->
    <key>NSCameraUsageDescription</key>
    <string>Camera permission is required for barcode scanning.</string>
    <!-- ... -->
</dict>
```


## Usage

```dart

import 'package:barcode_scan/barcode_scan.dart';

void main() async {
  var result = await CodebarScanner.scan();
  
  print(result.type); // The result type (barcode, cancelled, failed)
  print(result.rawContent); // The barcode content
  print(result.format); // The barcode format (as enum)
  print(result.formatNote); // If a unknown format was scanned this field contains a note
}
```


## Advanced usage
You can pass options to the scan method:

```dart

import 'package:barcode_scan/barcode_scan.dart';

void main() async {
  
  var options = ScanOptions(
    // set the options
  );

  var result = await CodebarScanner.scan(options: options);
  
  // ...
}
```

### Supported options
| Option                     | Type              | Description                                                                               | Supported by  |
|----------------------------|-------------------|-------------------------------------------------------------------------------------------|---------------|
| `strings.cancel`           | `String`          | The cancel button text on iOS                                                             | iOS only      |
| `strings.flash_on`         | `String`          | The flash on button text                                                                  | iOS + Android |
| `strings.flash_off`        | `String`          | The flash off button text                                                                 | iOS + Android |
| `restrictFormat`           | `CodebarFormat[]` | Restrict the formats which are recognized                                                 | iOS + Android |
| `useCamera`                | `int`             | The index of the camera which is used for scanning (See `CodebarScanner.numberOfCameras`) | iOS + Android |
| `autoEnableFlash`          | `bool`            | Enable the flash when start scanning                                                      | iOS + Android |
| `android.aspectTolerance`  | `double`          | Enable auto focus on Android                                                              | Android only  |
| `android.useAutoFocus`     | `bool`            | Set aspect ratio tolerance level used in calculating the optimal Camera preview size      | Android only  |

## Development setup

###  Setup protobuf

Mac:
```bash
$ brew install protobuf
$ brew install swift-protobuf
```
Windows / Linux: https://github.com/protocolbuffers/protobuf#protocol-compiler-installation


Activate the protobuf dart plugin:
`$ pub global activate protoc_plugin`

Install the`Protobuf Support` plugin for IDEA / Android Studio or `vscode-proto3` for VS Code

If you changed the protos.proto you've to execute the ./generate_proto.sh to update the dart / swift sources






## Common problems
### Android "Could not find org.jetbrains.kotlin:kotlin-stdlib-jre..."
Change `org.jetbrains.kotlin:kotlin-stdlib-jre` to `org.jetbrains.kotlin:kotlin-stdlib-jdk`
([StackOverflow](https://stackoverflow.com/a/53358817))
