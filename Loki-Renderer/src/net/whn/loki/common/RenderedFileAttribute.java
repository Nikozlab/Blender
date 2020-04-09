package net.whn.loki.common;

import java.io.File;
import java.io.Serializable;

public class RenderedFileAttribute implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    private File file;
    private Long fileLength;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }
}
