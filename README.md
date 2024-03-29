# Spring5 MVC REST backend web application for UPPERCASE band website


[![CircleCI](https://circleci.com/gh/markdeleon01/spring5_uppercaseband_webapp.svg?style=svg)](https://circleci.com/gh/markdeleon01/spring5_uppercaseband_webapp)

[![codecov](https://codecov.io/gh/markdeleon01/spring5_uppercaseband_webapp/branch/master/graph/badge.svg)](https://codecov.io/gh/markdeleon01/spring5_uppercaseband_webapp)

This repository is for a RESTful web application built on Spring Framework 5 for my band's website.

This is a Spring Boot web application that serves up articles regarding the UPPERCASE band.

The articles are categorized and displayed according to the various sections of the website,
such as highlights on the home page, events, discography section, and band information section;
they are stored in an H2 in-memory database and retrieved via JPA (relational database).

The article resources are exposed with the API route:
http://localhost:8080/api/v1/articles

JUnit4 tests were written to assert functionalities of the mapper, service, and controller classes.