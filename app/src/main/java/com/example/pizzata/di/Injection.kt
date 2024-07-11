import com.example.pizzata.data.repository.PizzaRepository

object Injection {
    fun provideRepository(): PizzaRepository {
        return PizzaRepository.getInstance()
    }
}