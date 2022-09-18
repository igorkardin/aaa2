sealed class Action {
    object Registration : Action()
    object Logout : Action()
    class Login(val lg: User) : Action()
}