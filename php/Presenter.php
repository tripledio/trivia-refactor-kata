<?php


interface Presenter
{
    function present(string $message): void;
}

class EchoPresenter implements Presenter
{
    function present(string $message): void
    {
        echo $message . "\n";
    }
}


class StringPresenter implements Presenter
{
    public string $data = "";

    function present(string $message): void
    {
        $this->data.=$message;
        $this->data.="\n";
    }
}


