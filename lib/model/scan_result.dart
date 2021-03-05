import '../gen/protos/protos.pb.dart';

/// Represents the result of a scan
class ScanResult {
  /// Represents the type of the result
  ResultsType type;

  /// The barcode itself if the result type is barcode.
  /// If the result type is error it contains the error message
  String rawContent;

  /// The barcode format
  CodebarFormat format;

  /// If the format is unknown, this field holds additional information
  String formatNote;

  /// Creates a new scan result
  ScanResult({
    this.type = ResultsType.Barcode,
    this.rawContent = "",
    this.format = CodebarFormat.unknown,
    this.formatNote = "",
  })  : assert(type != null),
        assert(rawContent != null),
        assert(format != null),
        assert(formatNote != null);
}
