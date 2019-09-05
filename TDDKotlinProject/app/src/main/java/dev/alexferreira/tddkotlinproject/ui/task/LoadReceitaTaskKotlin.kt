package dev.alexferreira.tddkotlinproject.ui.task

import dev.alexferreira.tddkotlinproject.data.model.Receita
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.ui.task.model.TaskResult

class LoadReceitaTaskKotlin(repo: IReceitaRepository, callback: TaskCallback<List<Receita>>) :
    DefaultLoadTask<List<Receita>, IReceitaRepository>(repo, callback) {

    override fun doInBackground(vararg params: String?): TaskResult<List<Receita>> {
        val all = repository.all
        builder.setIsEmpty(true)
        return builder.createTaskResult()
    }
}