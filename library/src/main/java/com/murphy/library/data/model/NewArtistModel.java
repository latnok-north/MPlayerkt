package com.murphy.library.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewArtistModel {

    private ArtistBeanX artist;

    public ArtistBeanX getArtist() {
        return artist;
    }

    public void setArtist(ArtistBeanX artist) {
        this.artist = artist;
    }

    public static class ArtistBeanX {
        /**
         * name : 陈粒
         * url : https://www.last.fm/music/%E9%99%88%E7%B2%92
         * image : [{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/f408f95cb9e50443f2262b182190e0da.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/f408f95cb9e50443f2262b182190e0da.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/f408f95cb9e50443f2262b182190e0da.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/f408f95cb9e50443f2262b182190e0da.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/f408f95cb9e50443f2262b182190e0da.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/f408f95cb9e50443f2262b182190e0da.png","size":""}]
         * streamable : 0
         * ontour : 0
         * stats : {"listeners":"1172","playcount":"44539"}
         * similar : {"artist":[{"name":"赵雷","url":"https://www.last.fm/music/%E8%B5%B5%E9%9B%B7","image":[{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/d66babb4df7c3bea962afa0118f0e226.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/d66babb4df7c3bea962afa0118f0e226.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/d66babb4df7c3bea962afa0118f0e226.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/d66babb4df7c3bea962afa0118f0e226.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/d66babb4df7c3bea962afa0118f0e226.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/d66babb4df7c3bea962afa0118f0e226.png","size":""}]},{"name":"薛之谦","url":"https://www.last.fm/music/%E8%96%9B%E4%B9%8B%E8%B0%A6","image":[{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/ee018dff14b4b8710e06ff70f2f181d1.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/ee018dff14b4b8710e06ff70f2f181d1.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/ee018dff14b4b8710e06ff70f2f181d1.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/ee018dff14b4b8710e06ff70f2f181d1.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/ee018dff14b4b8710e06ff70f2f181d1.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/ee018dff14b4b8710e06ff70f2f181d1.png","size":""}]},{"name":"朴树","url":"https://www.last.fm/music/%E6%9C%B4%E6%A0%91","image":[{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/66b3186934b9408a9a166914c5c9521d.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/66b3186934b9408a9a166914c5c9521d.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/66b3186934b9408a9a166914c5c9521d.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/66b3186934b9408a9a166914c5c9521d.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/66b3186934b9408a9a166914c5c9521d.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/66b3186934b9408a9a166914c5c9521d.png","size":""}]},{"name":"宋冬野","url":"https://www.last.fm/music/%E5%AE%8B%E5%86%AC%E9%87%8E","image":[{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/cf67a2b750854303c3f78618d8250d8c.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/cf67a2b750854303c3f78618d8250d8c.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/cf67a2b750854303c3f78618d8250d8c.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/cf67a2b750854303c3f78618d8250d8c.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/cf67a2b750854303c3f78618d8250d8c.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/cf67a2b750854303c3f78618d8250d8c.png","size":""}]},{"name":"李荣浩","url":"https://www.last.fm/music/%E6%9D%8E%E8%8D%A3%E6%B5%A9","image":[{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/6a3dcdd081cf43b5c3dff1815432c017.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/6a3dcdd081cf43b5c3dff1815432c017.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/6a3dcdd081cf43b5c3dff1815432c017.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/6a3dcdd081cf43b5c3dff1815432c017.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/6a3dcdd081cf43b5c3dff1815432c017.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/6a3dcdd081cf43b5c3dff1815432c017.png","size":""}]}]}
         * tags : {"tag":[{"name":"indie","url":"https://www.last.fm/tag/indie"},{"name":"indie pop","url":"https://www.last.fm/tag/indie+pop"},{"name":"chinese","url":"https://www.last.fm/tag/chinese"},{"name":"anti-folk","url":"https://www.last.fm/tag/anti-folk"},{"name":"mandarin","url":"https://www.last.fm/tag/mandarin"}]}
         * bio : {"links":{"link":{"#text":"","rel":"original","href":"https://last.fm/music/%E9%99%88%E7%B2%92/+wiki"}},"published":"01 Jan 1970, 00:00","summary":" <a href=\"https://www.last.fm/music/%E9%99%88%E7%B2%92\">Read more on Last.fm<\/a>","content":""}
         */

        private String name;
        private String url;
        private String streamable;
        private String ontour;
        private StatsBean stats;
        private SimilarBean similar;
        private TagsBean tags;
        private BioBean bio;
        private List<ImageBeanX> image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStreamable() {
            return streamable;
        }

        public void setStreamable(String streamable) {
            this.streamable = streamable;
        }

        public String getOntour() {
            return ontour;
        }

        public void setOntour(String ontour) {
            this.ontour = ontour;
        }

        public StatsBean getStats() {
            return stats;
        }

        public void setStats(StatsBean stats) {
            this.stats = stats;
        }

        public SimilarBean getSimilar() {
            return similar;
        }

        public void setSimilar(SimilarBean similar) {
            this.similar = similar;
        }

        public TagsBean getTags() {
            return tags;
        }

        public void setTags(TagsBean tags) {
            this.tags = tags;
        }

        public BioBean getBio() {
            return bio;
        }

        public void setBio(BioBean bio) {
            this.bio = bio;
        }

        public List<ImageBeanX> getImage() {
            return image;
        }

        public void setImage(List<ImageBeanX> image) {
            this.image = image;
        }

        public static class StatsBean {
            /**
             * listeners : 1172
             * playcount : 44539
             */

            private String listeners;
            private String playcount;

            public String getListeners() {
                return listeners;
            }

            public void setListeners(String listeners) {
                this.listeners = listeners;
            }

            public String getPlaycount() {
                return playcount;
            }

            public void setPlaycount(String playcount) {
                this.playcount = playcount;
            }
        }

        public static class SimilarBean {
            private List<ArtistBean> artist;

            public List<ArtistBean> getArtist() {
                return artist;
            }

            public void setArtist(List<ArtistBean> artist) {
                this.artist = artist;
            }

            public static class ArtistBean {
                /**
                 * name : 赵雷
                 * url : https://www.last.fm/music/%E8%B5%B5%E9%9B%B7
                 * image : [{"#text":"https://lastfm-img2.akamaized.net/i/u/34s/d66babb4df7c3bea962afa0118f0e226.png","size":"small"},{"#text":"https://lastfm-img2.akamaized.net/i/u/64s/d66babb4df7c3bea962afa0118f0e226.png","size":"medium"},{"#text":"https://lastfm-img2.akamaized.net/i/u/174s/d66babb4df7c3bea962afa0118f0e226.png","size":"large"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/d66babb4df7c3bea962afa0118f0e226.png","size":"extralarge"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/d66babb4df7c3bea962afa0118f0e226.png","size":"mega"},{"#text":"https://lastfm-img2.akamaized.net/i/u/300x300/d66babb4df7c3bea962afa0118f0e226.png","size":""}]
                 */

                private String name;
                private String url;
                private List<ImageBean> image;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<ImageBean> getImage() {
                    return image;
                }

                public void setImage(List<ImageBean> image) {
                    this.image = image;
                }

                public static class ImageBean {
                    @SerializedName("#text")
                    private String _$Text162; // FIXME check this code
                    private String size;

                    public String get_$Text162() {
                        return _$Text162;
                    }

                    public void set_$Text162(String _$Text162) {
                        this._$Text162 = _$Text162;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }
                }
            }
        }

        public static class TagsBean {
            private List<TagBean> tag;

            public List<TagBean> getTag() {
                return tag;
            }

            public void setTag(List<TagBean> tag) {
                this.tag = tag;
            }

            public static class TagBean {
                /**
                 * name : indie
                 * url : https://www.last.fm/tag/indie
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class BioBean {
            /**
             * links : {"link":{"#text":"","rel":"original","href":"https://last.fm/music/%E9%99%88%E7%B2%92/+wiki"}}
             * published : 01 Jan 1970, 00:00
             * summary :  <a href="https://www.last.fm/music/%E9%99%88%E7%B2%92">Read more on Last.fm</a>
             * content :
             */

            private LinksBean links;
            private String published;
            private String summary;
            private String content;

            public LinksBean getLinks() {
                return links;
            }

            public void setLinks(LinksBean links) {
                this.links = links;
            }

            public String getPublished() {
                return published;
            }

            public void setPublished(String published) {
                this.published = published;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public static class LinksBean {
                /**
                 * link : {"#text":"","rel":"original","href":"https://last.fm/music/%E9%99%88%E7%B2%92/+wiki"}
                 */

                private LinkBean link;

                public LinkBean getLink() {
                    return link;
                }

                public void setLink(LinkBean link) {
                    this.link = link;
                }

                public static class LinkBean {
                    @SerializedName("#text")
                    private String _$Text36; // FIXME check this code
                    private String rel;
                    private String href;

                    public String get_$Text36() {
                        return _$Text36;
                    }

                    public void set_$Text36(String _$Text36) {
                        this._$Text36 = _$Text36;
                    }

                    public String getRel() {
                        return rel;
                    }

                    public void setRel(String rel) {
                        this.rel = rel;
                    }

                    public String getHref() {
                        return href;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }
                }
            }
        }

        public static class ImageBeanX {
            @SerializedName("#text")
            private String url; // FIXME check this code
            private String size;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }
    }
}
