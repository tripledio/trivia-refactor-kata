import Presenter from "./presenter";

export default class SystemPresenter implements Presenter {
    public present(message: string | undefined) {
        console.log(message);
    }
}
