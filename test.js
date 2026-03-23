const { execSync } = require("child_process");

const username = "Gehan Fonseka";
const email = "GehanFonseka@users.noreply.github.com";

const schedule = [
  { date: "2026-03-23", commits: 3, label: "Project setup" },
  { date: "2026-03-24", commits: 5, label: "Update Swagger" },
  
];

function run(cmd) {
  execSync(cmd, { stdio: "inherit" });
}

schedule.forEach(day => {
  for (let i = 0; i < day.commits; i++) {

    const hour = 9 + Math.floor(Math.random() * 8); // 9AM–5PM
    const minute = Math.floor(Math.random() * 60);

    const fullDate = `${day.date}T${hour}:${minute}:00+05:30`;

    console.log(`Commit: ${day.label} at ${fullDate}`);

    run(`git add .`);

    run(`powershell -Command "$env:GIT_AUTHOR_DATE='${fullDate}'; $env:GIT_COMMITTER_DATE='${fullDate}'; git commit --allow-empty -m '${day.label} ${i+1}' --author='${username} <${email}>'"`);
  }
});

try {
  run("git push");
} catch {
  console.log("Force pushing...");
  run("git push --force");
}

console.log("All commits done!");