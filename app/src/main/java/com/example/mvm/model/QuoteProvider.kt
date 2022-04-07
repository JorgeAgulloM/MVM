package com.example.mvm.model

//
class QuoteProvider {
    companion object  {
        fun random():QuoteModel{
            val position:Int = (0..11).random()
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "Los ordenadores son inútiles. Sólo pueden darte respuestas",
                author = "Pablo Picasso"
            ),
            QuoteModel(
                quote = "Los ordenadores son como los bikinis. Ahorran a la gente el hacer muchas conjeturas",
                author = "Sam Ewing"
            ),
            QuoteModel(
                quote = "Tienen ordenadores, y pueden tener otras armas de destrucción masiva",
                author = "Janet Reno"
            ),
            QuoteModel(
                quote = "Si la industria automovilística hubiera seguido el mismo desarrollo que los " +
                        "ordenadores, un Rolls-Royce costaría hoy 100 dólares, circularía un millón de " +
                        "millas con 3,7 litros y explotaría una vez al año, eliminando a todo el que " +
                        "estuviera dentro en ese momento",
                author = "Robert X. Cringely"
            ),
            QuoteModel(
                quote = "Los ordenadores se hacen cada vez más inteligentes. Los científicos dicen que " +
                        "pronto ellos serán capaces de hablarnos (y con 'ellos' me refiero a los " +
                        "ordenadores, dudo mucho que los científicos sean capaces de hablarnos)",
                author = "Dave Barry"
            ),
            QuoteModel(
                quote = "He notado últimamente que el miedo paranoico hacia ordenadores inteligentes " +
                        "tomando el control del mundo ha desaparecido totalmente. Todo lo que puedo " +
                        "contar es que este hecho coincide con la aparición de MS-DOS",
                author = "Larry DeLuca"
            ),
            QuoteModel(
                quote = "Preguntarse cuándo los ordenadores podrán pensar es como preguntarse cuándo " +
                        "los submarinos podrán nadar",
                author = "Edsger W. Dijkstra"
            ),
            QuoteModel(
                quote = "Es ridículo vivir 100 años y sólo ser capaces de recordar 30 millones de " +
                        "bytes. O sea, menos que un compact disc. La condición humana se hace más " +
                        "obsoleta cada minuto",
                author = "Marvin Minsky"
            ),
            QuoteModel(
                quote = "R2D2, ¿te lo dijo la computadora central de la ciudad? ¡R2D2, sabes bien " +
                        "que no debes confiar en una computadora extraña!",
                author = "C3PO"
            ),
            QuoteModel(
                quote = "Nunca confíes en un ordenador que no puedas lanzar por una ventana",
                author = "Steve Wozniak"
            ),
            QuoteModel(
                quote = "Hardware: las partes de un ordenador que pueden ser pateadas",
                author = "Jeff Pesis"
            )

        )
    }
}
