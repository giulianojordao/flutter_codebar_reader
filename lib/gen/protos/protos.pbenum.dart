///
//  Generated code. Do not modify.
//  source: protos/protos.proto
//
// @dart = 2.7
// ignore_for_file: annotate_overrides,camel_case_types,unnecessary_const,non_constant_identifier_names,library_prefixes,unused_import,unused_shown_name,return_of_invalid_type,unnecessary_this,prefer_final_fields

// ignore_for_file: UNDEFINED_SHOWN_NAME
import 'dart:core' as $core;
import 'package:protobuf/protobuf.dart' as $pb;

class CodebarFormat extends $pb.ProtobufEnum {
  static const CodebarFormat unknown = CodebarFormat._(0, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'unknown');
  static const CodebarFormat aztec = CodebarFormat._(1, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'aztec');
  static const CodebarFormat code39 = CodebarFormat._(2, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'code39');
  static const CodebarFormat code93 = CodebarFormat._(3, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'code93');
  static const CodebarFormat ean8 = CodebarFormat._(4, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'ean8');
  static const CodebarFormat ean13 = CodebarFormat._(5, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'ean13');
  static const CodebarFormat code128 = CodebarFormat._(6, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'code128');
  static const CodebarFormat dataMatrix = CodebarFormat._(7, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'dataMatrix');
  static const CodebarFormat qr = CodebarFormat._(8, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'qr');
  static const CodebarFormat interleaved2of5 = CodebarFormat._(9, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'interleaved2of5');
  static const CodebarFormat upce = CodebarFormat._(10, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'upce');
  static const CodebarFormat pdf417 = CodebarFormat._(11, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'pdf417');
  static const CodebarFormat brazilianboleto = CodebarFormat._(12, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'brazilianboleto');
  static const CodebarFormat febraban = CodebarFormat._(13, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'febraban');
  static const CodebarFormat itf = CodebarFormat._(14, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'itf');

  static const $core.List<CodebarFormat> values = <CodebarFormat> [
    unknown,
    aztec,
    code39,
    code93,
    ean8,
    ean13,
    code128,
    dataMatrix,
    qr,
    interleaved2of5,
    upce,
    pdf417,
    brazilianboleto,
    febraban,
    itf,
  ];

  static final $core.Map<$core.int, CodebarFormat> _byValue = $pb.ProtobufEnum.initByValue(values);
  static CodebarFormat valueOf($core.int value) => _byValue[value];

  const CodebarFormat._($core.int v, $core.String n) : super(v, n);
}

class ResultsType extends $pb.ProtobufEnum {
  static const ResultsType Barcode = ResultsType._(0, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'Barcode');
  static const ResultsType Cancelled = ResultsType._(1, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'Cancelled');
  static const ResultsType Error = ResultsType._(2, const $core.bool.fromEnvironment('protobuf.omit_enum_names') ? '' : 'Error');

  static const $core.List<ResultsType> values = <ResultsType> [
    Barcode,
    Cancelled,
    Error,
  ];

  static final $core.Map<$core.int, ResultsType> _byValue = $pb.ProtobufEnum.initByValue(values);
  static ResultsType valueOf($core.int value) => _byValue[value];

  const ResultsType._($core.int v, $core.String n) : super(v, n);
}

