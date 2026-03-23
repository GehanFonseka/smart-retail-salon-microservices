# Author details (YOUR ACCOUNT)
$AUTHOR_NAME="GehanFonseka"
$AUTHOR_EMAIL="Gehanfonseka@gmail.com"

# Files to modify (adjust if needed)
$FILES = @(
    "appointment-service/src/main/java",
    "api-gateway"
    
)

# Times per day
$TIMES = @("10:00:00","13:00:00","16:00:00","19:00:00")

# Date range
$startDate = Get-Date "2026-03-23"
$endDate   = Get-Date "2026-03-25"

$currentDate = $startDate

while ($currentDate -le $endDate) {

    # Random commits per day (2–5)
    $commitCount = Get-Random -Minimum 2 -Maximum 5

    for ($i = 0; $i -lt $commitCount; $i++) {

        $time = $TIMES | Get-Random
        $fullDate = "$($currentDate.ToString("yyyy-MM-dd"))T$time+05:30"

        Write-Host "Commit: $fullDate"

        # Pick random file or create dummy change
        $file = Get-ChildItem -Recurse -File | Get-Random

        # Add a harmless change
        Add-Content $file.FullName "`n// update $i - $($currentDate.ToString("yyyy-MM-dd"))"

        git add .

        $env:GIT_AUTHOR_NAME=$AUTHOR_NAME
        $env:GIT_AUTHOR_EMAIL=$AUTHOR_EMAIL
        $env:GIT_AUTHOR_DATE=$fullDate
        $env:GIT_COMMITTER_DATE=$fullDate

        git commit -m "Port update - $($currentDate.ToString("yyyy-MM-dd"))"

        Remove-Item Env:GIT_AUTHOR_DATE -ErrorAction SilentlyContinue
        Remove-Item Env:GIT_COMMITTER_DATE -ErrorAction SilentlyContinue
    }

    $currentDate = $currentDate.AddDays(1)
}

# Force push to update history
git push --force

Write-Host "Done!"