package com.a4a.budok.data

import budok.Actions
import com.a4a.budok.Database

class ActionsDataSource(
    db: Database,
) {
    private val actionsQueries = db.actionsQueries

    fun fetchAllActions(): List<Action> {
        return actionsQueries.getActions()
            .executeAsList()
            .map { it.transformIntoEditableAction() }
    }
}

data class Action(
    var id: Int? = null,
    var number: Int = 1,
    var description: String = "",
)

fun Actions.transformIntoEditableAction(): Action {
    return Action(
        id = this.id.toInt(),
        number = this.number?.toInt() ?: 1,
        description = this.description
    )
}
