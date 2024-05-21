package com.a4a.budok.data

import budok.Vocabulary
import com.a4a.budok.Database

class VocabDataSource(
    db: Database,
) {
    private val vocabularyQueries = db.vocabularyQueries

    fun fetchAllVocabulary(): List<Vocab> {
        return vocabularyQueries.getVocabulary()
            .executeAsList()
            .map { it.transformIntoEditableVocabulary() }
    }
}

data class Vocab(
    var id: Int? = null,
    var word: String = "",
    var translation: String = "",
)

fun Vocabulary.transformIntoEditableVocabulary(): Vocab {
    return Vocab(
        id = this.id.toInt(),
        word = this.word,
        translation = this.translation
    )
}
