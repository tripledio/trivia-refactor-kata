function commit() {
  ##choose your commit option. Working locally on a branch or pushing immediately to remote repository with pure git or with mob.sh

  ## Option 1 Locally
  echo "Committing changes locally"
  git add . && git commit -m "WIP"

  ## Option 2 remote repo
  ## echo "Committing and pushing changes"
  ## git add . && git commit -m "WIP" && git push

  ## Option 3 Mob.sh
  ## If using mob.sh, otherwise use the above line
  # mob next
}