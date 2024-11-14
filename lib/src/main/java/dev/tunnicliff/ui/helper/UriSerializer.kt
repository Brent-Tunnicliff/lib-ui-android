// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.helper

import android.net.Uri
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Uri::class)
internal object UriSerializer : KSerializer<Uri> {
    override fun deserialize(decoder: Decoder): Uri =
        Uri.parse(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Uri) =
        encoder.encodeString(value.toString())
}
