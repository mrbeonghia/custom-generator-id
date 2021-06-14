package com.example.examplemodule4;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StringGeneratorId implements IdentifierGenerator {
    private String prefix = "EMP";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        QueryImplementor<String> query = session.createQuery("SELECT e.id FROM Employee e", String.class);
//        try(Stream<String> stream = query.stream()) {
//            Long max = stream.map(t -> t.replace(prefix,""))
//                    .mapToLong(Long::parseLong)
//                    .max()
//                    .orElse(0L);
//            return prefix+String.format("%04d",max+1);
//
//        }

        Connection connection = session.connection();
        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(city_id) as Id from city");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated ID: "+generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
