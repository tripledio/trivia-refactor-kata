function commit() {
  echo "Committing and pushing changes"
  argument=${@:-"WIP - all test pass"}
  # Basic git usage
  git add . && git commit -m "$argument" && git push

  ## If using mob.sh, otherwise use the above line
   #mob next -m "$argument"
}