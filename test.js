const { execSync } = require("child_process");

const username = "Gehan Fonseka";
const email = "GehanFonseka@users.noreply.github.com";

// Dates you want commits on
const dates = [
  "2026-03-23",
  "2026-03-24",
];

// Number of commits per day
const commitsPerDay = 3;

function run(command) {
  execSync(command, { stdio: "inherit" });
}

dates.forEach(date => {
  for (let i = 0; i < commitsPerDay; i++) {
    const hour = 9 + i * 3; // spread commits across day
    const fullDate = `${date}T${hour}:00:00+05:30`;

    console.log(`Creating commit for ${fullDate}`);

    run(`git add .`);

    run(`git commit --allow-empty -m "Swagger update ${i + 1}" \
--date="${fullDate}" \
--author="${username} <${email}>"`);
  }
});

// push at end
run("git push");

console.log("Done!");