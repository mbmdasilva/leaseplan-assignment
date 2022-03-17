Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios
  @test
  Scenario: check for apple products
    When he calls endpoint "/api/v1/search/test/apple"
    Then he sees the results displayed for "apple"

  @test
  Scenario: check for mango products
    When he calls endpoint "/api/v1/search/test/mango"
    Then he sees the results displayed for "mango"

  @test
  Scenario: check for a product that is not available
    When he calls endpoint "/api/v1/search/test/car"
    Then he does not see the results
