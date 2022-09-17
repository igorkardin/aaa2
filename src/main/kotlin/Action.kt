sealed class Action {
    class Registration() : Action()
    class Logout() : Action()
    class Login(val lg: User) : Action()
}