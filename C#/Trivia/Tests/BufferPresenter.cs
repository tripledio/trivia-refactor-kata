using Trivia;

namespace Tests;

public class BufferPresenter : IPresenter
{
    private readonly List<string> _messages = new();

    public void Present(string message) {
        _messages.Add(message);
    }

    public List<string> GetBufferedMessages() {
        return _messages;
    }
}