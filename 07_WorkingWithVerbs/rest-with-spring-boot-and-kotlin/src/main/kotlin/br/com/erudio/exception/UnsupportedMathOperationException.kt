package br.com.erudio.exception

import java.lang.RuntimeException

class UnsupportedMathOperationException(exception: String?) : RuntimeException(exception) {
}