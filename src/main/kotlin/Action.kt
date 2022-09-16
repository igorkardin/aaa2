sealed class Action {
    class Registration() : Action()
    class Logout() : Action()
    class Login(lg: User) : Action()
}