package java_adv2.io.member.impl;

import java_adv2.io.member.Member;
import java_adv2.io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DataMemberRepository implements MemberRepository {

    private final static String FILE_PATH = "temp/members-data.dat";

    @Override
    public void add(Member member) {
        try(DataOutputStream dos = new DataOutputStream((new FileOutputStream(FILE_PATH, true)))) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream((new FileInputStream(FILE_PATH)))){
            while (dis.available() > 0) {
                members.add(new Member(dis.readUTF(), dis.readUTF(), dis.readInt()));
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
