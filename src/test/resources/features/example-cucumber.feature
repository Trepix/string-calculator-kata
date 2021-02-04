Feature: Given a feature
  With a description

  Scenario: A described scenario
    Given a thing with value '1234'
    And a list of instances of AClass:
      | first | second |
      |   1   |   one  |
      |   2   |   two  |
      |   3   |  three |
      |   4   |  four  |
      |   5   |  five  |
      |   6   |   six  |
      |   7   | seven  |
    When execute the thing with value '1234'
    Then do something with value 'value' with this text
      """
      Long text!

      Really long text

      * You can add list
      * Another element list

      End of long text
      """
