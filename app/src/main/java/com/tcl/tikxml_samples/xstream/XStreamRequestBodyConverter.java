package com.tcl.tikxml_samples.xstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * XStreamRequestBodyConverter
 * Created by wangzhen on 2021/10/9
 */
public class XStreamRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/xml; charset=UTF-8");
    private static final String CHARSET = "UTF-8";
    private final XStream xstream;

    public XStreamRequestBodyConverter(XStream xstream) {
        this.xstream = xstream;
    }

    @Nullable
    @Override
    public RequestBody convert(@NonNull T value) throws IOException {
        String xml = xstream.toXML(value);
        return RequestBody.create(MEDIA_TYPE, xml.getBytes(CHARSET));
    }
}
