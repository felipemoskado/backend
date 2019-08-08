package main.kotlin.extensions

import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId

fun LocalDate.atStartDay(zoneId: ZoneId = ZoneId.of("America/Sao_Paulo")): OffsetDateTime =
        this.atStartOfDay().atZone(zoneId).toOffsetDateTime()

fun LocalDate.atEndDay(zoneId: ZoneId = ZoneId.of("America/Sao_Paulo")): OffsetDateTime =
        this.atTime(23, 59, 59).atZone(zoneId).toOffsetDateTime()

fun LocalDate.toOffsetDateTime(time: LocalTime, zoneId: ZoneId = ZoneId.of("America/Sao_Paulo")): OffsetDateTime =
        this.atTime(time).atZone(zoneId).toOffsetDateTime()

