package com.tcl.tikxml_samples.entity

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicit

@XStreamAlias("ArrayOfString")
class RandomFontsResp {
    @XStreamImplicit(itemFieldName = "string")
    var datas: List<String>? = null

    override fun toString(): String {
        return "RandomFontsResp(datas=$datas)"
    }
}