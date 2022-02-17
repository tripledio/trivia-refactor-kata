using System;

namespace Trivia;

public class ConsolePresenter : IPresenter
{
    public void Present(string message) => Console.Out.WriteLine(message);
}