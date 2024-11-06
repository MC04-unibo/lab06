/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
    */
    HashMap<Integer,U> followedUser;
    HashMap<Integer,String> userInGroup;
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        followedUser = new HashMap<Integer,U>();
        userInGroup = new HashMap<Integer,String>();
    }
    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
        followedUser = new HashMap<Integer,U>();
        userInGroup = new HashMap<Integer,String>();
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        followedUser.put(user.hashCode(),user);
        boolean added = userInGroup.put(Objects.hash(user.hashCode(),circle),circle) != null;

        return added;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Collection<U> followedUsersInGroup= new HashSet<U>();
        
        for (int key : followedUser.keySet()) {
            String group = userInGroup.get(Objects.hash(followedUser.get(key).hashCode(),groupName));
            if(group != null){
                followedUsersInGroup.add(followedUser.get(key));
            }
        }
        return followedUsersInGroup;
    }

    @Override
    public List<U> getFollowedUsers() {
        List<U> getFollowed = new ArrayList<U>();
        for (int key : followedUser.keySet()) {
            getFollowed.add(followedUser.get(key));
        }
        return getFollowed;
    }
}