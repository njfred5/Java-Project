Branching & Pushing Guide

This document explains how to create your own Git branch in this project, switch to it, and push your changes.

1. Clone the Project (If Needed)
   git clone <repository-url>
   cd <project-folder>
2. Create Your Own Branch

Create and switch to a new branch:

  git checkout -b <your-branch-name>

Examples:

  git checkout -b feature/login-system
  git checkout -b bugfix/api-crash
3. Switch to an Existing Branch

  If the branch already exists:

    git checkout <branch-name>

  List branches:

    git branch

  List local + remote branches:

    git branch -a
4. Commit Your Work

  After you make changes:

    git add .
    git commit -m "Describe your changes"
5. Push Your Branch to GitHub

  Push a branch for the first time:

    git push -u origin <your-branch-name>

  Example:

    git push -u origin feature/login-system

  After the first push, you can simply use:

    git push
6. Pull Remote Updates

  To pull updates into your current branch:

    git pull

  To pull from a specific branch:

    git pull origin <branch-name>



