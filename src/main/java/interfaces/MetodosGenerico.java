package interfaces;

import java.util.ArrayList;

public interface MetodosGenerico<Generico> {

    ArrayList<Generico> listar();

    Generico crear(Generico generico);
}
