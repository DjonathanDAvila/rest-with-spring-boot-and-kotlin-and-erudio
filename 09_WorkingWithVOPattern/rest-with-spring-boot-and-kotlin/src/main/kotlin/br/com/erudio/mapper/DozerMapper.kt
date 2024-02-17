package br.com.erudio.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

object DozerMapper {

    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

    /*Function que converte um objeto para outro objeto*/
    fun <O, D> perseObject(origin: O, destination: Class<D>?): D {
        return mapper.map(origin, destination)
    }

    fun <O, D> perseListObject(origin: List<O>, destination: Class<D>?): List<D> {
        val destinationObjects: ArrayList<D> = ArrayList()
        for (o in origin) {
            destinationObjects.add(mapper.map(origin, destination))
        }
        return destinationObjects
    }
}