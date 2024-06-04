package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "post")
public class Post implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private long postID;

    @Column(name = "name_post")
    private String postName;

    @Override
    public String getAuthority() {
        List<String> posts = new ArrayList<>();
        posts.add(postName);
        return posts.getFirst();
    }
}
