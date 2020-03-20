# GoodMorningProject

## **First** Create Your Own Branch: 
1. ```git checkout <frontend/backend/sources/database>```  
    <b style="color:grey">switch to the branch of your role  </b>
2. ```git checkout -b <your branch name>```  
    <b style="color:grey">create your own branch (e.g. Nate, better if name after your name)</b>
3. ```git push origin <your branch name>```  
    <b style="color:grey">push your newly created branch to the REMOTE repository</b>

## Git Process:
1. Always work on our own branches when developing. (use ```git checkout <your branch name>``` in your project directory)<br /> <br/>
    <b style="color:red">Don't</b> directly work on the <b style="color:orangered; font-weight: 3000;">master </b> branch or the <b style="color:brown">frontend/backend/sources/database</b> branch.<br/><br/>
2. After fully testing your code, use the following steps to push to your branch remotely on github so that others can integrate your code into their own branches<br/><br/>
    - ```git add .``` 
    <br />&nbsp;&nbsp;&nbsp;&nbsp;**or**
     <br /> ```git add <filenames of the files that you newly created, such as index.html>```)<br/><br/>
    - ```git commit -m <some description about why you are pushing these files to the remote branch so that others can understand what you are doing in this update, and it would also be helpful if we later want to reset to this update>```<br/><br/>
    - ```git push origin <your branch name, such as Nate>```<br/><br/>
    - Tell others on Slack that you just pushed your code on your branch (if you think is necessary to merge your code into others'), so that someone can merge it into  
    <b style="color:brown">frontend/backend/sources/database</b> branch  
    &nbsp;&nbsp;&nbsp;&nbsp;**AND**  
    then <b style="color:orangered; font-weight: 3000;">master </b>branch<br/><br/>
    - After someone merges it into the <b style="color:orangered; font-weight: 3000;">master </b> branch, please use ```git pull origin master``` to integrate the updated part into your project.<br/><br/>
3. If we want to test the project, we can test it on the <b style="color:orangered; font-weight: 3000;">master </b> branch<br/><br/>
4. If we <i>implemented, improved, or modified</i> some important functionalities (such as if we updated a machine learning function or created a new user interface in frontend), and everything goes well on the <b style="color:orangered; font-weight: 3000;">master </b>branch, then we can create a new branch called ```release-<version number>```. This makes it easier for us to go back to a version if we find something goes wrong in the future development.