#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
Feature: Scraping opinion articles from El Pais

  Scenario: Scrape titles and content of the first 5 articles
    Given I visit the El Pais Opinion section
    When I fetch the first 5 articles
    Then I print the title and content of each article in Spanish
