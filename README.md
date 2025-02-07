# Spring Webhook Sample

This repository contains a sample Spring Boot application that demonstrates how to implement and handle webhooks. Webhooks are a way for applications to provide real-time information to other applications by sending HTTP POST requests to a specified URL when certain events occur.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)

## Introduction

This project is a simple Spring Boot application that showcases how to set up a webhook endpoint, handle incoming webhook requests, and process the data. It can be used as a starting point for integrating webhooks into your own Spring Boot applications.

## Features

- **Webhook Endpoint**: A REST controller that exposes an endpoint to receive webhook payloads.
- **Payload Processing**: Example logic to process and log incoming webhook data.
- **Customizable**: Easily extendable to handle different types of webhook events and integrate with other services.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 21 or higher
- Maven 3.x
- An IDE (e.g., IntelliJ IDEA, Eclipse)
- Postman or any HTTP client for testing

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/OlaAref/spring-webhook-sample.git
   ```

2. **Build and run the consumer service**:\
The application will start on port 8080 by default.

   ```bash
   cd spring-webhook-sample/webhook
   mvn clean install
   mvn spring-boot:run
   ```
   
3. **Build and run the client service**:\
   The application will start on port 8081.

   ```bash
   cd spring-webhook-sample/first-school
   mvn clean install
   mvn spring-boot:run
   ```
   
   