import com.example.trashure.data.repository.PizzaRepository

object Injection {
    fun provideRepository(): PizzaRepository {
        return PizzaRepository.getInstance()
    }
}