#####git checkout -b dev  》创建一个名字叫dev的分支，并切换到它
#####git push --set-upstream origin dev：dev 》在远程也建立一个dev分支，并且和本地对应
#####git branch test 》创建一个名字叫test的分支
#####git checkout test 》切换到test分支
#####git checkout -b dev origin/dev 》在本地建立一个dev分支，并和远程分支origin/dev关联，并切换到dev分支
#####git branch -d dev  》删除本地dev分支
#####git push origin :dev 》删除远程dev分支
#####要想重命名远程分支的名称，只能先删掉远程分支，然后修改本地分支名称之后推送到远程