package com.practice.androidapp.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class System implements Parcelable {

    private String author;
    private List<ChildrenDTO> children;
    private int courseId;
    private String cover;
    private String desc;
    private int id;
    private String lisense;
    private String lisenseLink;
    private String name;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;

    protected System(Parcel in) {
        author = in.readString();
        children = in.createTypedArrayList(ChildrenDTO.CREATOR);
        courseId = in.readInt();
        cover = in.readString();
        desc = in.readString();
        id = in.readInt();
        lisense = in.readString();
        lisenseLink = in.readString();
        name = in.readString();
        order = in.readInt();
        parentChapterId = in.readInt();
        userControlSetTop = in.readByte() != 0;
        visible = in.readInt();
    }

    public static final Creator<System> CREATOR = new Creator<System>() {
        @Override
        public System createFromParcel(Parcel in) {
            return new System(in);
        }

        @Override
        public System[] newArray(int size) {
            return new System[size];
        }
    };

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenDTO> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLisense() {
        return lisense;
    }

    public void setLisense(String lisense) {
        this.lisense = lisense;
    }

    public String getLisenseLink() {
        return lisenseLink;
    }

    public void setLisenseLink(String lisenseLink) {
        this.lisenseLink = lisenseLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeTypedList(children);
        dest.writeInt(courseId);
        dest.writeString(cover);
        dest.writeString(desc);
        dest.writeInt(id);
        dest.writeString(lisense);
        dest.writeString(lisenseLink);
        dest.writeString(name);
        dest.writeInt(order);
        dest.writeInt(parentChapterId);
        dest.writeByte((byte) (userControlSetTop ? 1 : 0));
        dest.writeInt(visible);
    }

    public static class ChildrenDTO implements Parcelable {
        private List<?> children;
        private int courseId;
        private int id;
        private String name;
        private int order;
        private int parentChapterId;
        private boolean userControlSetTop;
        private int visible;

        protected ChildrenDTO(Parcel in) {
            courseId = in.readInt();
            id = in.readInt();
            name = in.readString();
            order = in.readInt();
            parentChapterId = in.readInt();
            userControlSetTop = in.readByte() != 0;
            visible = in.readInt();
        }

        public static final Creator<ChildrenDTO> CREATOR = new Creator<ChildrenDTO>() {
            @Override
            public ChildrenDTO createFromParcel(Parcel in) {
                return new ChildrenDTO(in);
            }

            @Override
            public ChildrenDTO[] newArray(int size) {
                return new ChildrenDTO[size];
            }
        };

        public List<?> getChildren() {
            return children;
        }

        public void setChildren(List<?> children) {
            this.children = children;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getParentChapterId() {
            return parentChapterId;
        }

        public void setParentChapterId(int parentChapterId) {
            this.parentChapterId = parentChapterId;
        }

        public boolean isUserControlSetTop() {
            return userControlSetTop;
        }

        public void setUserControlSetTop(boolean userControlSetTop) {
            this.userControlSetTop = userControlSetTop;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(courseId);
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeInt(order);
            dest.writeInt(parentChapterId);
            dest.writeByte((byte) (userControlSetTop ? 1 : 0));
            dest.writeInt(visible);
        }
    }
}
