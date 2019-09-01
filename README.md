
#  Java course homeworks
This repo was created for students to submit their homeworks for review. 

### How to submit
- fork this repository
- clone your fork to your local machine: `git clone https://github.com/YOUR_USERNAME/java-2019-homeworks.git`
- add this repository as an upstream: `git remote add upstream https://github.com/njuics/java-2019-homeworks.git`
- in your local repository, add a folder with your github name under  `submissions` (if you haven't yet)
- in your local repository, under your name folder, add a folder with task name and put your code in the folder


- make pull-request to this repository following these steps:
  - `git checkout master` and then create new branch, name it according to task performed (aka feature branch): `git checkout -b huluwa`. In this example feature branch is called `huluwa`
  - commit your changes to newly created feature branch
  - checkout `master` branch: `git checkout master`
  - pull latest changes from upstream `master` branch: `git pull upstream master`
  - merge `master` branch into your feature branch: `git checkout huluwa && git merge master`
  - resolve any merge conflicts if there are any
  - push feature branch to your remote repository: `git push --set-upstream origin huluwa`
  - make pull-request from your repository to this repository via GitHub web-interface
- post a link to your subtask PR in QQ group and ask mentors for a code review
     * wait for review from course mentors
     * if necessary, make changes, until your code will be approved and merged