Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation successful with correct username and password
        Given new user is selected
        When correct username "jukka" and password "akkuj" are given
        Then  user is created

    Scenario: creation fails with too short username and valid passord
        Given new user is selected
        When incorrect username "33" and password "akkdd34uj" are given
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When correct username "jukka" and password "33" are given
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails with correct username and password consisting of letters
        Given new user is selected
        When correct username "jukka" and password "akkuj" are given
        Then user is not created and error "password can not contain only letters" is reported 

    Scenario: creation fails with already taken username and valid pasword
        Given new user is selected
        When correct username "pekka" and password "akkuj" are given
        Then user is not created and error "username is already taken" is reported 

    Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When correct username "jukka" and password "akkuj2" and confirmation "lol" are given
        Then user is not created and error "password and password confirmation do not match" is reported   