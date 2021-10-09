package com.tcl.tikxml_samples.xstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * XStreamRequestBodyConverter
 * Created by wangzhen on 2021/10/9
 */
public class XStreamRequestBodyConverter<T> implements Converter<T, RequestBody> {
    @Nullable
    @Override
    public RequestBody convert(@NonNull T value) throws IOException {
        return null;
    }
}
