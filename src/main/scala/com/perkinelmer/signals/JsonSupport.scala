package com.perkinelmer.signals

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import spray.json.{DefaultJsonProtocol, JsString, JsValue, JsonFormat}

//trait JsonMarshallers extends DefaultJsonProtocol {
//  implicit val DigestItemWireFormat = jsonFormat6(DigestItemWire.apply)
//
//  implicit val LocalDateTimeFormat = new JsonFormat[LocalDateTime] {
//
//    private val iso_date_time = DateTimeFormatter.ISO_DATE_TIME
//
//    def write(x: LocalDateTime) = JsString(iso_date_time.format(x))
//
//    def read(value: JsValue) = value match {
//      case JsString(x) => LocalDateTime.parse(x, iso_date_time)
//      case x => throw new RuntimeException(s"Unexpected type %s on parsing of LocalDateTime type".format(x.getClass.getName))
//    }
//  }
//}
