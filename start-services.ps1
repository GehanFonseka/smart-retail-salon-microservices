#!/usr/bin/env pwsh

# Smart Retail Salon Microservices Startup Script
# This script starts all microservices and the API Gateway

$services = @{
    "customer-service" = 8083
    "product-service" = 8082
    "appointment-service" = 8086
    "order-service" = 8084
    "payment-service" = 8087
    "salon-service" = 8085
    "api-gateway" = 8080
}

Write-Host "=====================================================`n" -ForegroundColor Cyan
Write-Host "Starting Smart Retail Salon Microservices Platform`n" -ForegroundColor Cyan
Write-Host "=====================================================`n" -ForegroundColor Cyan

$baseDir = Split-Path -Parent $MyInvocation.MyCommand.Path

foreach ($service in $services.GetEnumerator()) {
    $serviceName = $service.Key
    $port = $service.Value
    
    Write-Host "Starting $serviceName on port $port..." -ForegroundColor Green
    
    $serviceDir = Join-Path $baseDir $serviceName
    
    if (Test-Path $serviceDir) {
        Push-Location $serviceDir
        Start-Process -FilePath ".\mvnw.cmd" -ArgumentList "spring-boot:run" -NoNewWindow
        Pop-Location
        Start-Sleep -Seconds 2
    } else {
        Write-Host "  ❌ Directory not found: $serviceDir" -ForegroundColor Red
    }
}

Write-Host "`n=====================================================`n" -ForegroundColor Cyan
Write-Host "All services started! Waiting for them to initialize...(~30 seconds)`n" -ForegroundColor Cyan
Write-Host "API Gateway will be available at: http://localhost:8080/swagger-ui/index.html`n" -ForegroundColor Yellow
Write-Host "=====================================================`n" -ForegroundColor Cyan

Start-Sleep -Seconds 30

# Open Swagger UI
Write-Host "Opening Swagger UI in browser..." -ForegroundColor Green
Start-Process "http://localhost:8080/swagger-ui/index.html"
