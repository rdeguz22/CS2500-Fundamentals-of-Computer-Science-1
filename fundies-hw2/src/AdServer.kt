// Congratulations! You've been invited to do the following
// online assessment for a co-op with tech giant Oodle.
//
// 1. Add the 3+ constants from the pre-exercise to the Gender enum.
// 2. Define at least 2 age-based constants where indicated below to
//    make your later ad-serving code more readable and maintainable.
//    Choose general names, such as MIN_ADULT_AGE rather than ones that
//    refer to ads, such as MIN_AGE_FOR_DATING_AD. You can also use
//    numeric literals. (Look up terms if you don't understand them.
//    They may appear on tests!)
// 3. Add properties minAge and maxAge to Ad, and set values for each
//    ad. For example, minAge for the dating ad might be MIN_ADULT_AGE.
// 4. Implement the provided fetchAd() function. You must use both "if"
//    and "when". Paste in the tests from the pre-exercise. Uncomment
//    the call to runTests() in main(). Run the tests, and see if they
//    all pass. In your write-up, you will need to describe the testing
//    and debugging process, so take notes.
// 5. Create a new data class named "Person". A person should have an
//    age (Int), gender (Gender), and income (Int). Use your judgment
//    as to which properties should be changeable.
// 6. Write a new fetchAd() method (without removing the original one)
//    that takes a single parameter of type Person and returns an Ad.
//    Instead of duplicating the code in your original fetchAd() method,
//    have your new method call your old method, passing the appropriate
//    properties as arguments.
// 7. Create a new function named "testFetchAdPerson" that tests your
//    new fetchAd() method. Modify runTests() to call this new function.

/**
 * Types of Genders
 *
 * @property Male male gender
 * @property Female female gender
 * @property Nonbinary nonbinary gender
 */
enum class Gender {
    Unspecified,

    // 1. Add the 3+ constants from the pre-exercise to the Gender enum.
    Male,
    Female,
    Nonbinary
}

// Age-based constants
const val MIN_AGE_FOR_PERSONALIZATION = 13
const val MIN_ADULT_AGE = 18

// 2. Define at least 2 age-based constants where indicated below to
//    make your later ad-serving code more readable and maintainable.
//    Choose general names, such as MIN_ADULT_AGE rather than ones that
//    refer to ads, such as MIN_AGE_FOR_DATING_AD.
const val SENIOR_AGE = 75
const val MIDDLE_AGE = 25
const val OLDER_MIDDLE_AGE = 30
const val TEEN = 15
const val HALF = 50
const val STARTING_SENIOR = 55
const val ROARING = 20
const val PIECE = 40
const val SENIOR = 60


// 3. Add properties minAge and maxAge to Ad, and set values for each
//    ad. For example, minAge for the dating ad might be MIN_ADULT_AGE.
//    You can also use numeric literals. (Look up terms if you don't understand
//    them. They may appear on tests!) Be sure to update the KDoc.

/**
 * Ads that may be shown to users.
 *
 * @property text the text of the ad
 * @property revenue the number of cents earned per click
 * @property minAge the minimum age for the ad target
 * @property maxAge the maximum age for the ad target
 */
enum class Ad(
    val text: String,
    val revenue: Int,
    val minAge: Int,
    val maxAge: Int
) {
    Diet("Lose weight now!", 5, TEEN, OLDER_MIDDLE_AGE),
    Dating("Meet other singles!", 4, TEEN, PIECE),
    Lego("Fun to step on!", 1, MIN_AGE_FOR_PERSONALIZATION, ROARING),
    Pet("You need a friend!", 1, MIDDLE_AGE, HALF),
    PetToy("Amuse your pet!", 2, MIDDLE_AGE, HALF),
    Pokemon("Gotta catch 'em all!", 2, MIN_AGE_FOR_PERSONALIZATION, ROARING),
    Retirement("Join AARP", 2, STARTING_SENIOR, SENIOR_AGE),
    Work("Apply for a job at Oodle!", 2, MIN_ADULT_AGE, SENIOR),
}

/**
 * Fetches an ad based on the user's [gender], [age], and
 * [income], unless the age is under [MIN_AGE_FOR_PERSONALIZATION],
 * in which case no personalization is permitted.
 */
fun fetchAd(
    gender: Gender,
    age: Int,
    income: Int,
): Ad {
    // 4a. Implement the provided fetchAd() function. You must use
    //     both "if" and "when".
    // return Ad.Work // This is just a temporary default return value.
    var adUno = Ad.Work
    if (income < 20000 && age >= MIN_AGE_FOR_PERSONALIZATION) {
        return when (gender) {
            Gender.Male -> Ad.Work
            Gender.Female -> Ad.PetToy
            else -> Ad.Lego
        }
    } else if (income < 40000 && age >= MIN_AGE_FOR_PERSONALIZATION) {
        return when (gender) {
            Gender.Male -> Ad.Diet
            Gender.Female -> Ad.Work
            else -> Ad.Pokemon
        }
    } else if (income < 60000 && age >= MIN_AGE_FOR_PERSONALIZATION) {
        return when (gender) {
            Gender.Male -> Ad.Dating
            Gender.Female -> Ad.Pet
            else -> Ad.Pet
        }
    } else if (income < 100000 && age >= MIN_AGE_FOR_PERSONALIZATION) {
        return when (gender) {
            Gender.Male -> Ad.Pet
            Gender.Female -> Ad.Diet
            else -> Ad.Diet
        }
    } else if (age >= MIN_AGE_FOR_PERSONALIZATION) {
        return when (gender) {
            Gender.Male -> Ad.Retirement
            Gender.Female -> Ad.Retirement
            else -> Ad.Dating
        }
    }
    return adUno
}


fun ageRanges(age: Int) {
    when (age) {
        in Ad.Diet.minAge..Ad.Diet.maxAge -> Ad.Diet.text
        in Ad.Dating.minAge..Ad.Dating.maxAge -> Ad.Pet.text
        in Ad.Lego.minAge..Ad.Lego.maxAge -> Ad.Lego.text
        in Ad.Pet.minAge..Ad.Pet.maxAge -> Ad.Pet.text
        in Ad.PetToy.minAge..Ad.PetToy.maxAge -> Ad.PetToy.text
        in Ad.Pokemon.minAge..Ad.Pokemon.maxAge -> Ad.Pokemon.text
        in Ad.Retirement.minAge..Ad.Retirement.maxAge -> Ad.Retirement.text
        in Ad.Work.minAge..Ad.Work.maxAge -> Ad.Work.text
    }
}

// 4b. Paste in the tests from the pre-exercise.
fun testWork1() {
    assertEquals(Ad.Work, fetchAd(Gender.Male, 18, 0))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 18, 19999))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 18, 9999))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 60, 0))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 60, 19999))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 60, 9999))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 39, 0))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 39, 19999))
    assertEquals(Ad.Work, fetchAd(Gender.Male, 39, 9999))
}


fun testDiet2() {
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 15, 20000))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 15, 39999))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 15, 29999))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 30, 20000))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 30, 39999))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 30, 29999))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 22, 20000))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 22, 39999))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 22, 29999))
}


fun testDating3() {
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 15, 40000))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 15, 59999))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 15, 49999))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 40, 40000))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 40, 59999))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 40, 49999))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 27, 40000))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 27, 59999))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 27, 49999))
}


fun testPet4() {
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 25, 60000))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 25, 99999))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 25, 79999))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 50, 60000))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 50, 99999))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 50, 79999))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 37, 60000))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 37, 99999))
    assertEquals(Ad.Pet, fetchAd(Gender.Male, 37, 79999))
}


fun testRetirement5() {
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 55, 100000))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 55, 999999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 55, 549999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 75, 100000))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 75, 999999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 75, 549999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 65, 100000))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 65, 999999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 65, 549999))
}


fun testPetToy6() {
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 25, 0))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 25, 19999))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 25, 9999))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 50, 0))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 50, 19999))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 50, 9999))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 37, 0))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 37, 19999))
    assertEquals(Ad.PetToy, fetchAd(Gender.Female, 37, 9999))
}


fun testWork7() {
    assertEquals(Ad.Work, fetchAd(Gender.Female, 18, 20000))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 18, 39999))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 18, 29999))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 60, 20000))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 60, 39999))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 60, 29999))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 39, 20000))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 39, 39999))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 39, 29999))
}


fun testPet8() {
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 25, 40000))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 25, 59999))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 25, 49999))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 50, 40000))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 50, 59999))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 50, 49999))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 37, 40000))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 37, 59999))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 37, 49999))
}


fun testDiet9() {
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 15, 60000))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 15, 99999))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 15, 79999))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 30, 60000))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 30, 99999))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 30, 79999))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 22, 60000))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 22, 99999))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 22, 79999))
}


fun testRetirement10() {
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 55, 100000))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 55, 999999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 55, 549999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 75, 100000))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 75, 999999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 75, 549999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 65, 100000))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 65, 999999))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 65, 549999))
}


fun testLego11() {
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 13, 0))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 13, 19999))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 13, 9999))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 20, 0))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 20, 19999))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 20, 9999))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 16, 0))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 16, 19999))
    assertEquals(Ad.Lego, fetchAd(Gender.Nonbinary, 16, 9999))
}


fun testPokemon12() {
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 13, 20000))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 13, 39999))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 13, 29999))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 20, 20000))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 20, 39999))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 20, 29999))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 16, 20000))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 16, 39999))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 16, 29999))
}


fun testPet13() {
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 25, 40000))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 25, 59999))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 25, 49999))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 50, 40000))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 50, 59999))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 50, 49999))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 37, 40000))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 37, 59999))
    assertEquals(Ad.Pet, fetchAd(Gender.Nonbinary, 37, 49999))
}


fun testDiet14() {
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 15, 60000))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 15, 99999))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 15, 79999))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 30, 60000))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 30, 99999))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 30, 79999))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 22, 60000))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 22, 99999))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 22, 79999))
}


fun testDating15() {
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 15, 100000))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 15, 999999))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 15, 549999))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 40, 100000))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 40, 999999))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 40, 549999))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 27, 100000))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 27, 999999))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 27, 549999))
}


fun testAll() {
    testWork1()
    testDiet2()
    testDating3()
    testPet4()
    testRetirement5()
    testPetToy6()
    testWork7()
    testPet8()
    testDiet9()
    testRetirement10()
    testLego11()
    testPokemon12()
    testPet13()
    testDiet14()
    testDating15()
    testFetchAdPerson()
    print("All tests pass.")
}

// 4c. Uncomment the call to runTests() in main(). Run the tests, and see
//     if they all pass. In your write-up, you will need to describe the
//     testing and debugging process, so take notes.
fun main() {
    testAll()
}

// 5. Create a new data class named "Person". A person should have an
//    age (Int), gender (Gender), and income (Int). Use your judgment
//    as to which properties should be changeable.
/**
 * Person and the attributes that determine the ad target
 *
 * @property age the age of the person
 * @property gender the gender of the person
 * @property income the income of the person
 */
data class Person(
    var age: Int,
    var gender: Gender,
    var income: Int
)

// 6. Write a new fetchAd() method (without removing the original one)
//    that takes a single parameter of type Person and returns an Ad.
//    Instead of duplicating the code in your original fetchAd() method,
//    have your new method call your old method, passing the appropriate
//    properties as arguments.
/**
 * Fetches an ad based on the gender, age, and income and takes in a Person parameter
 */
fun fetchAd(people: Person): Ad {
    return fetchAd(people.gender, people.age, people.income)
}

// 7. Create a new function named "testFetchAdPerson" that tests your
//    new fetchAd() method. Modify runTests() to call this new function.
/**
 * Tests the fetchAd() function
 */
fun testFetchAdPerson() {
    val rico = Person(20, Gender.Male, 50000)
    assertEquals(Ad.Dating, fetchAd(rico))
    val marco = Person(25, Gender.Male, 20000)
    assertEquals(Ad.Diet, fetchAd(marco))
    val jim = Person(60, Gender.Male, 200000)
    assertEquals(Ad.Retirement, fetchAd(jim))
    val nina = Person(40, Gender.Female, 50000)
    assertEquals(Ad.Pet, fetchAd(nina))
    val avery = Person(18, Gender.Female, 10000)
    assertEquals(Ad.PetToy, fetchAd(avery))
    val mia = Person(15, Gender.Female, 20000)
    assertEquals(Ad.Work, fetchAd(mia))
    val connor = Person(17, Gender.Nonbinary, 10000)
    assertEquals(Ad.Lego, fetchAd(connor))
    val kim = Person(12, Gender.Nonbinary, 10000)
    assertEquals(Ad.Work, fetchAd(kim))
    val cate = Person(35, Gender.Nonbinary, 45000)
    assertEquals(Ad.Pet, fetchAd(cate))
}

// Do not modify the following code.

/**
 * Verifies that [actual] is equal to [expected].
 *
 * @throws AssertionError if they are not equal
 */
fun assertEquals(
    expected: Any,
    actual: Any,
) {
    if (expected != actual) {
        throw AssertionError("Expected $expected, got $actual")
    }
}
