package com.qa.pageobject.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class FileUpload {

    public void anyfileUpload(String value) {

        //fileUpload
        /* данное решение показывает откуда загружаем файлы (src/test/data/demoPracticeFormUploads) для загрузки различных файлов в данную форму */

        $x("//input[@id ='uploadPicture']").uploadFile(new File(value));
       // $x("//input[@id ='uploadPicture']").uploadFromClasspath(value);

     /*
      $x("//input[@id ='uploadPicture']").uploadFromClasspath("1.png"); работает только с элеменотом у которого есть type=file
      смотрит сразу в папку resourсes, показывает относительный путь

      */
    }
}
