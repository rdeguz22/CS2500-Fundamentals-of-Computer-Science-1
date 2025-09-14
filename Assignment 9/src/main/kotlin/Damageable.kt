/**
 * Something capable of taking damage.
 */
interface Damageable {
    /**
     * Takes up to [damage] units of damage,
     * printing a message with the amount of damage taken.
     */
    fun takeDamage(damage: Int)
}
