package com.hiraok.github_contributors_app

import android.graphics.*
import com.squareup.picasso.Transformation
import java.lang.IllegalStateException
import kotlin.math.min


class CircleTransform : Transformation {

    companion object {
        const val KEY = "circleView"
    }

    override fun key(): String = KEY

    override fun transform(source: Bitmap?): Bitmap {
        source?.let {
            val size = min(it.width, it.height)

            val x = (it.width - size) / 2
            val y = (it.height - size) / 2

            val squaredBitmap = Bitmap.createBitmap(it, x, y, size, size)
            if (squaredBitmap != it) {
                it.recycle()
            }

            val bitmap = Bitmap.createBitmap(size, size, it.config)

            val canvas = Canvas(bitmap)
            val paint = Paint()
            val shader = BitmapShader(
                squaredBitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
            )

            paint.shader = shader
            paint.isAntiAlias = true

            val r = size / 2f
            canvas.drawCircle(r, r, r, paint)

            squaredBitmap.recycle()
            return bitmap

        } ?: throw IllegalStateException("bitmap source is null")
    }


}